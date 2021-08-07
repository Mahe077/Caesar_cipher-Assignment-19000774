import scala.io.StdIn._
import scala.io.Source._

object Caesar_cipher extends App{
  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "
  val Encryption = (c:Char,key:Int,s:String) => (s((s.indexOf(c.toUpper) + key)%s.size))
  val Decryption = (c:Char,key:Int,s:String) => (if((s.indexOf(c.toUpper) - key) <0) s(s.size - math.abs((s.indexOf(c.toUpper) - key)%s.size)) else s((s.indexOf(c.toUpper) - key)%s.size)) 
  val Cipher = (f:(Char, Int, String) => Char,c:Char,key:Int,s:String) => f(c:Char,key:Int,s:String)
  
//  Inputs
  val file= "src/sample.txt"
  val charcter = 'e'
  val key = 3

  val source = fromFile(file,"UTF-8").getLines.mkString.toUpperCase
  println("Original string 	: " + source)
  
  val encryptedString = source.map(x => Cipher(Encryption,x,key,alphabet))
  println("Encrypted string	: " + encryptedString)
  
  val decryptLetter = encryptedString.map(y => Cipher(Decryption,y,key,alphabet))
  println("Decrypted string 	: " + decryptLetter)
 
  
}