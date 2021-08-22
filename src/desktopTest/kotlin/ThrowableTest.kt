import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.ShouldSpec

class ThrowableTest : ShouldSpec() {
   init {
      should("support shouldThrow") {
         shouldThrow<IllegalStateException> {
            error("foo")
         }
      }

      should("support shouldThrowAny") {
         shouldThrowAny {
            error("foo")
         }
      }
   }
}
