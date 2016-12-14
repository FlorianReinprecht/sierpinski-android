package net.ladstatt.sierpinski

// TODO
// implement here all domain logic
// Pos / Triangle / Sierpinski





case class Pos(var x:Float, var y:Float)
case class Triangle(var a:Pos, var b:Pos, var c:Pos, var color:SColor) {

  val top:Pos = Pos((this.a.x+this.b.x)/2,(this.a.y+this.b.y)/2)
  println(top)
  val left:Pos = Pos((this.a.x+this.c.x)/2,(this.a.y+this.c.y)/2)
  println(left)
  val right:Pos = Pos((this.b.x+this.c.x)/2,(this.b.y+this.c.y)/2)
  println(right)


  val leftTriangle:Triangle = Triangle(a,top,left,SColor(1.0,1.0,1.0))
  val rightTriangle:Triangle = Triangle(top,b,right,SColor(1.0,1.0,1.0))
  val bottomTriangle:Triangle =  Triangle(left,right,c,SColor(1.0,1.0,1.0))

  val siblings:List[Triangle] = List(leftTriangle,rightTriangle,bottomTriangle)
  val centerT :Triangle = new Triangle(left,right,top,SColor(0,0,0))

}

  object Triangle {
    def apply(a: Pos, length:Int) = new Triangle(a, Pos(length,0), Pos(length/2,(Math.sqrt(3) / 2).toFloat*length),SColor(1.0,1.0,1.0) )
  }

case class SColor(var a:Double,var b:Double, var c:Double) {

}

case class Sierpinski(var triangles:List[Triangle]){

}
object Sierpinski {
  def apply(triangle:Triangle, recursiveLevel:Int) = new Sierpinski(triangle.siblings)

}


