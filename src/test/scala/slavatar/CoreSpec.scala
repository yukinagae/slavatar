package slavatar

import org.specs2.mutable._

class CoreSpec extends Specification {

  "basics" should {

    import Core._

    "Clavatar core functionality" in {

      gravatar(email = "i@raynes.me") mustEqual "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=retro&"

      gravatar(email = "i@raynes.me", size = 500) mustEqual "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=pg&d=retro&"

      gravatar(email = "i@raynes.me", size = 500, rating = "g") mustEqual "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=g&d=retro&"

      gravatar(email = "i@raynes.me", size = 500, rating = "r") mustEqual "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=500&r=r&d=retro&"

      gravatar(email = "i@raynes.me", default = "mm") mustEqual "https://secure.gravatar.com/avatar/54222b6321f0504e0a312c24e97adfc1.jpg?s=50&r=pg&d=mm&"

      gravatar(email = "b.ghose@gmail.com", default = "mm", size = 128, https = false) mustEqual "http://www.gravatar.com/avatar/8aa4490274249db8981283bdadb2ec2b.jpg?s=128&r=pg&d=mm&"
    }
  }

}