package com.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

/**
 * Hello world!
 *
 */
public class MainVerticle extends AbstractVerticle
{
	@Override
	public void start(Future<Void> startFuture) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Application Verticle is starting... ");
		
		vertx.createHttpServer()
			.requestHandler(r -> {
				r.response().end("<h1>My first vertx application... </h1>");
			})
			.listen(8080, resp -> {
				if (resp.succeeded()) {
					startFuture.complete();
				} else {
					startFuture.fail("Http server did not start... ");
				}
			});
			
	}
    
	public static void main(String[] args) {
		
		Vertx vertx = Vertx.vertx();
		vertx.deployVerticle(new MainVerticle());
		
	}
}
