class Accumulate {
  def accumulate[T, S](op: T => S ,list: List[T]) = list map op
}
