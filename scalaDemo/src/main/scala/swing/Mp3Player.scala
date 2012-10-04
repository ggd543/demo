///*
// * Created by IntelliJ IDEA.
// * User: Administrator
// * Date: 12-8-26
// * Time: 下午2:46
// */
//package swing
//
//import javazoom.jl.player.FactoryRegistry
//import actors.Actor
//import scala.actors.Actor._
//import swing.SimpleSwingApplication
//import swing._
//import java.io.{FileInputStream, InputStream}
//import swing.event._
//import javazoom.jl.decoder.{SampleBuffer, Decoder, Bitstream}
//import java.util.Arrays
//
//
///**
// * Created by IntelliJ IDEA.
// * User: Administrator
// * Date: 2010-12-26
// * Time: 10:17:35
// * 我们自己的播放器 ;这个例子需要使用javazoom类库。实现的是Actor的通信，进行暂停控制。
// */
//
//class Player(var stream: InputStream) extends Actor {
//    val bitstream = new Bitstream(stream)
//    val decoder = new Decoder
//    val audio = FactoryRegistry.systemRegistry.createAudioDevice
//
//    var closed = false
//    var complete = false
//    var lastPosition = 0
//    var paused = false
//    var frames = 0
//
//    audio.open(decoder)
//
//    println(audio.isOpen)
//
//    def act() {
//        play()
//    }
//
//    def close: Unit = {
//        audio.close
//        lastPosition = audio.getPosition
//        bitstream.close
//    }
//
//    def play() ={
//        var ret = true
//        while (ret) {
//            if (paused) {
//                println("paused")
//                Thread.sleep(100)
//            } else {
//                ret = decodeFrame
//                frames =  + 1
//                //println(frames)
//            }
//        }
//        if (!ret) {
//            audio.flush
//            close
//        }
//    }
//
//    def decodeFrame: Boolean = {
//        try {
//            val h = bitstream.readFrame
//            val output = decoder.decodeFrame(h, bitstream).asInstanceOf[SampleBuffer]
//            //println("output:" + Arrays.toString(output.getBuffer))
//            audio.write(output.getBuffer, 0, output.getBufferLength)
//            //println("decoding...")
//            bitstream.closeFrame
//            true
//        } catch {
//            case e: Exception =>
//                e.printStackTrace
//                return false
//        }
//    }
//}
//
//object Player extends SimpleSwingApplication {
//    val test = new FileInputStream("d:/hero.mp3")
//
//    val myplay = new Player(test)
//
//    val controler = actor {
//        loop {
//            react {
//                case "play" =>
//                    if (myplay.paused) {
//                        myplay.paused = false
//                    }
//                    else {
//                        myplay.start
//                    }
//                case "pause" => myplay.paused = true
//            }
//        }
//    }
//
//    controler.start
//
//    val play = new Button {
//        text = "play"
//    }
//
//    val pause = new Button {
//        text = "pause"
//    }
//
//    val mainpanel = new FlowPanel {
//        contents ++ Array(play, pause)
//    }
//
//    def top = new MainFrame {
//        title = "my player"
//        contents = mainpanel
//    }
//
//    listenTo(play, pause)
//    reactions += {
//        case ButtonClicked(b) => b.text match {
//            case "play" => controler ! "play"
//            case "pause" => controler ! "pause"
//        }
//    }
//
//}