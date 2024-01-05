import akka.actor._

class HelloActor(actor_name: String) extends Actor {
  def receive = {
    case "hello" => println("Hello from %s! How are you?".format(actor_name))
    case _       => println("%s: What?".format(actor_name))
  }
}

object AkkaActor extends App {
  val system = ActorSystem("Test")
  val helloActor = system.actorOf(Props(new HelloActor("Actor")), name = "newactor")
  helloActor ! "hello"
  helloActor ! "it`s me"
}