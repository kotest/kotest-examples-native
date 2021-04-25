import io.kotest.matchers.shouldBe
import kotlin.test.Test

class MyTests {

   // a SSN should be invalid when it contains a zero in any position
   @Test
   fun validateSSN() {
      validateSocial("543-23-5013") shouldBe false
      validateSocial("043-23-5313") shouldBe false
      validateSocial("313-03-5310") shouldBe false
   }

   // a SSN should be invalid when it starts with 666
   @Test
   fun invalidateSSN() {
      validateSocial("666-23-1234") shouldBe false
   }

   // a SSN should be in the required format
   @Test
   fun formatTests() {
      validateSocial("123-45-6789") shouldBe true
      validateSocial("123-45-678") shouldBe false
      validateSocial("12-45-6789") shouldBe false
      validateSocial("1234-56-678") shouldBe false
      validateSocial("123456789") shouldBe false
      validateSocial("123-456789") shouldBe false
      validateSocial("12345-6789") shouldBe false
      validateSocial("") shouldBe false
   }
}
