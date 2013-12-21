package rpg

trait CharacterGetter[X,C <: Character[_,_,_]] {

  def get(c: C, x: X): Option[Int]

}
