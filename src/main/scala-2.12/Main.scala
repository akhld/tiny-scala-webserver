
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.AbstractHandler

/**
  * Created by akhld on 13/1/17.
  */

object Main{

  def main(args: Array[String]) ={

    val port = args(0).toInt
    val server = new Server(port)
    server.setHandler(new MyHandler())

    server.start()
    server.join()

    println(s"Server started $port")

  }
}


class MyHandler extends AbstractHandler {

  def handle(target: String,
             baseRequest: Request,
             request: HttpServletRequest,
             response: HttpServletResponse ): Unit ={

    response.setContentType("text/html; charset=utf-8")
    response.setStatus(HttpServletResponse.SC_OK)
    response.getWriter.println("<br><br><br><br><br><br><center>" +
                               "<h1>Hello from Pricing!</h1>")
    baseRequest.setHandled(true)
  }


}