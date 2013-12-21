package rpg

/** Represents the outcome of a check.
  *
  * @see [[rpg.Result.Success]]
  * @see [[rpg.Result.Failure]]
  * @see [[rpg.Result.Tie]]
  */
sealed abstract class Result

object Result {

  /** The acting party succeeded in any way.
    *
    * @see [[rpg.Result.Succeeded]]
    * @see [[rpg.Result.Superior]]
    */
  abstract class Success extends Result

  /** The acting party failed in any way.
    *
    * @see [[rpg.Result.Failed]]
    * @see [[rpg.Result.Inferior]]
    * @see [[rpg.Result.Incapable]]
    */
  abstract class Failure extends Result

  /** The acting party performs as well as the reacting party. */
  case class Tie(description: String = "a tie") extends Result

  /** The acting party is incapable of performing the check. */
  case class Incapable(description: String = "unable to perform") extends Failure

  /** The acting party is inferior. */
  case class Inferior(description: String = "cannot win") extends Failure

  /** The acting party is superior. */
  case class Superior(description: String = "cannot lose") extends Success

  /** The acting party failed. */
  case class Failed(description: String = "failed") extends Failure

  /** The acting party succeeded. */
  case class Succeeded(description: String = "succeeded") extends Success

}
