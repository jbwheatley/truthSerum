package object truthSerum:
  type T = True
  type F = False

  type |[L1, L2] = ![![L1] & ![L2]]
  type ->[L1, L2] = ![L1 & ![L2]]
  type <->[L1, L2] = L1 -> L2 & (L2 -> L1)
