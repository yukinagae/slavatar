package slavatar

import java.security.MessageDigest
import java.math.BigInteger

object Core {

  val gravatar_base_url = ".gravatar.com/avatar/"

  def md5sum(s: String): String = {
    val digest = MessageDigest.getInstance("MD5")
    digest.reset
    val h = digest.digest(s.getBytes("UTF-8"))
    val b = new BigInteger(1, h)
    b.toString(16)
  }

  def genhash(email: String): String = {
    md5sum(email.trim.toLowerCase)
  }

  def genparams(size: Int, default: String, rating: String): String = {
    "?s=%s&r=%s&d=%s&".format(size, rating, default)
  }

  def gravatar(email: String, size: Int = 50, default: String = "retro", rating: String = "pg", https: Boolean = true): String = {
    val base_url = s"${gravatar_base_url}${genhash(email)}.jpg${genparams(size, default, rating)}"

    if (https) {
      s"https://secure${base_url}"
    } else {
      s"http://www${base_url}"
    }
  }

}
