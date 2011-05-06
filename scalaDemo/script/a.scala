trait TAction {  
    def doAction 
}  

trait TBeforeAfterAction extends TAction {  
	abstract override def doAction {  

        println("/entry before-action") //doAction的前置处理  

        super.doAction // 调用原来的处理  

        println("/exit after-action") //doAction的后置处理  

    }  

}  

class RealAction extends TAction {  
    def doAction = { println("** real action done!! **") }  
}  

val ta = new RealAction() with TBeforeAfterAction{
	override def doAction = super.doAction
}

trait TException extends TAction {
    abstract override def doAction(){
        throw new RuntimeException
    }
}

abstract class ExceptionAction extends TAction{
    def doAction(): Unit = println("hello");
}

class TmpAction extends ExceptionAction with TException{
    def func = super.doAction
}

val te = new TmpAction with TException
val te = new ExceptionAction() with TException{}


