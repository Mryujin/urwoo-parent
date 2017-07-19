package com.urwoo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class HttpServerVerticle extends AbstractVerticle {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpServerVerticle.class);

    public static final String CONFIG_HTTP_SERVER_PORT = "http.server.port";

    public static void main(String[] args) throws IOException {

        String verticleID = HttpServerVerticle.class.getName();
        VertxOptions options = new VertxOptions();
        Consumer<Vertx> runner = vertx -> {
            vertx.deployVerticle(verticleID);
        };
        // Vert.x实例是vert.x api的入口点，我们调用vert.x中的核心服务时，均要先获取vert.x实例，
        // 通过该实例来调用相应的服务，例如部署verticle、创建http server
        Vertx vertx = Vertx.vertx(options);
        runner.accept(vertx);
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.get("/").handler(this::indexHandler);
        router.route(HttpMethod.POST,"/upload")
                .handler(BodyHandler.create())  //BodyHandler处理文件上传
                .handler(this::upload);
/*        router.get("/wiki/:page").handler(this::pageRenderingHandler);
        router.post().handler(BodyHandler.create());
        router.post("/save").handler(this::pageUpdateHandler);
        router.post("/create").handler(this::pageCreateHandler);
        router.post("/delete").handler(this::pageDeletionHandler);*/

        int portNumber = config().getInteger(CONFIG_HTTP_SERVER_PORT, 8080);
        server.requestHandler(router::accept).listen(portNumber, ar -> {
            if (ar.succeeded()) {
                LOGGER.info("HTTP server running on port " + portNumber);
                startFuture.complete();
            } else {
                LOGGER.error("Could not start a HTTP server", ar.cause());
                startFuture.fail(ar.cause());
            }
        });
    }

    private void indexHandler(RoutingContext context){
        System.err.println("首页数据聚合");
        //DeliveryOptions options = new DeliveryOptions().addHeader("action", "all-pages");
        String id = context.request().getParam("id");
        System.err.println("请求参数："+id);
        context.response().end("大家好"+id);
    }

    private void upload(RoutingContext context){
        System.out.printf("--->"+context.getAcceptableContentType());
        Set<FileUpload> uploads = context.fileUploads();
        Iterator<FileUpload> fileUploads = uploads.iterator();
        while(fileUploads.hasNext()){
            FileUpload fileUpload = fileUploads.next();
            Buffer uploadedFile = vertx.fileSystem().readFileBlocking(fileUpload.uploadedFileName());
            try {
                String fileName = URLDecoder.decode(fileUpload.fileName(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}
