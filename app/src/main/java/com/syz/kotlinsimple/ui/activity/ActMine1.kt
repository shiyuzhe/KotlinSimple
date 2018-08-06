package com.syz.kotlinsimple.ui.activity

import android.media.Image
import android.media.MediaPlayer
import android.media.ThumbnailUtils
import android.net.Uri
import android.provider.MediaStore
import android.view.SurfaceHolder
import android.view.View
import com.orhanobut.logger.Logger
import com.syz.kotlinsimple.R
import com.syz.kotlinsimple.base.BaseActivity
import kotlinx.android.synthetic.main.act_mine1.*

const val a = 0

class ActMine1 : BaseActivity() {

    private val filePath = "http://video.dushuren123.com/lecture1523517197.mp3"
    var isSurfaceCanPlay = false
    var isCreatingSurface = false
    val player by lazy {
        MediaPlayer()
    }

    override fun layoutId(): Int = R.layout.act_mine1

    override fun initData() {
        Logger.e("InitData")
    }

    override fun initView() {
        player.setOnCompletionListener { it.start() }
        player.setOnPreparedListener { it.start() }
        player.setOnErrorListener(MediaPlayer.OnErrorListener { player, what, extra ->
            player.start()
            false
        })
        play.setOnClickListener {
            if (checkSurfaceCanPlay()) {
                if (player.isPlaying) {
                    player.pause()
                } else {
                    player.start()
                    img.visibility = View.GONE
                }
            } else {
                //preparing draw surface
                Logger.e("preparing draw surface")
            }
        }
    }

    private fun checkSurfaceCanPlay(): Boolean {
        if (!isSurfaceCanPlay) {
            if (!isCreatingSurface) {
                val bitmap = ThumbnailUtils.createVideoThumbnail(filePath, MediaStore.Images.Thumbnails.FULL_SCREEN_KIND)
                img.setImageBitmap(bitmap)
                surface.holder.addCallback(object : SurfaceHolder.Callback {
                    override fun surfaceCreated(holder: SurfaceHolder) {
                        isSurfaceCanPlay = true
                        isCreatingSurface = false
                        player.setDisplay(holder)

                    }

                    override fun surfaceChanged(holder: SurfaceHolder, format: Int,
                                                width: Int, height: Int) {
                        // TODO Auto-generated method stub
                    }

                    override fun surfaceDestroyed(holder: SurfaceHolder) {
                        isSurfaceCanPlay = false
                    }
                })

            } else {
                isCreatingSurface = true
            }
            return false
        } else {
            return true
        }


    }

    override fun start() {
        checkSurfaceCanPlay()
        val uri = Uri.parse(filePath)
        player.setDataSource(this, uri)
        player.prepareAsync()


    }


    var string: String? = null
        get() = field + "-get"
        set(value) {
            field = value + "-set"
        }

    val string2: String? = null
        get() = field + "-get"

    override fun onPause() {
        super.onPause()
        player.pause()
    }

    override fun onDestroy() {
        if (player.isPlaying) {
            player.pause()
            player.release()
        }
        super.onDestroy()
    }
}
