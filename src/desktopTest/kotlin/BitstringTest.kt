import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class BitstringTest : FunSpec() {
   init {

      test("bigstring should set bits based on booleans") {
         bitstring(listOf(true, false, true, false, true)) shouldBe "10101"
         bitstring(listOf(false, false, false, false, false, false, false, true)) shouldBe "00000001"
      }
   }
}
