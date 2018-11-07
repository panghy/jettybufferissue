package com.github.panghy.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

@Path("/")
public class TestApi {

  @GET
  public Response manyThreads() {
    return Response.ok().type(MediaType.TEXT_PLAIN).
        entity((StreamingOutput) outputStream -> {
          Thread t = new Thread(() -> {
            while (true) {
              try {
                outputStream.write("writing from thread\n".getBytes());
                outputStream.flush();
              } catch (Throwable e) {
                e.printStackTrace();
                return;
              }
            }
          });
          t.start();
          while (true) {
            try {
              outputStream.write("writing from lambda\n".getBytes());
              outputStream.flush();
            } catch (Throwable e) {
              e.printStackTrace();
              return;
            }
          }
        }).build();
  }
}
