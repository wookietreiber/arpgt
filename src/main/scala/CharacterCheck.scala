package rpg

trait CharacterCheck[X,C <: Character[_,_,_]] {

  def check(c: C, x: X): Result

}
