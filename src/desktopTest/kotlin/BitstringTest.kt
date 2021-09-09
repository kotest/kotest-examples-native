import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class BitstringTest : DescribeSpec() {
   init {
      describe("bit strings") {
         it("should set bits based on booleans") {
            bitstring(listOf(true, false, true, false, true)) shouldBe "10101"
            bitstring(listOf(false, false, false, false, false, false, false, true)) shouldBe "00000001"
         }
         it("should set bits based on booleans") {
            bitstring(listOf(true, false, true, false, true)) shouldBe "10101"
            bitstring(listOf(false, false, false, false, false, false, false, true)) shouldBe "00000001"
         }
      }
   }
}
