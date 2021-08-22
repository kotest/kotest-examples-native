fun bitstring(bits: List<Boolean>): String {
   return buildString {
      repeat(bits.size) {
         if (bits[it]) append("1") else append("0")
      }
   }
}
