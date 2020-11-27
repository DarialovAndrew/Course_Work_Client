import java.io.{DataInputStream, InputStream}
import java.net.Socket

object Client_1 {

  def main(args: Array[String]): Unit = {
    println("How inaccurate is the clock")
    val serverName: String = "localhost"
    val serverPort: Int = 8080
    val request_time: Long = System.currentTimeMillis()
    val client: Socket = new Socket(serverName, serverPort)
    val inFromServer: InputStream = client.getInputStream
    val in: DataInputStream = new DataInputStream(inFromServer)
    val server_time: Long = in.readLong()
    val response_time: Long = System.currentTimeMillis()
    println("Time returned by server: " + server_time)
    val process_delay_latency: Long = response_time - request_time
    println("Process delay latency: " + process_delay_latency)
    val client_time: Long = server_time + process_delay_latency / 2
    println("New time for client: " + client_time)
  }

}