import android.graphics.Bitmap
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.Key
import java.security.MessageDigest

class BlackWhiteTransformation : BitmapTransformation() {

    private val ID = "com.example.yourapp.BlackWhiteTransformation"
    private val ID_BYTES = ID.toByteArray(Key.CHARSET)

    override fun transform(pool: BitmapPool, toTransform: Bitmap, outWidth: Int, outHeight: Int): Bitmap {
        return toBlackWhite(toTransform)
    }

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(ID_BYTES)
    }

    private fun toBlackWhite(source: Bitmap): Bitmap {
        val bmpGrayscale = Bitmap.createBitmap(source.width, source.height, Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(bmpGrayscale)
        val paint = android.graphics.Paint()
        val colorMatrix = android.graphics.ColorMatrix()
        colorMatrix.setSaturation(0f)
        val filter = android.graphics.ColorMatrixColorFilter(colorMatrix)
        paint.colorFilter = filter
        canvas.drawBitmap(source, 0f, 0f, paint)
        return bmpGrayscale
    }
}
