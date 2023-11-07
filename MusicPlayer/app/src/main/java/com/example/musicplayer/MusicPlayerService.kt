package com.example.musicplayer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import java.io.IOException

class MusicPlayerService : Service(),
MediaPlayer.OnPreparedListener {

    private lateinit var mediaPlayer: MediaPlayer
    private var currentTrack = 0
    private lateinit var trackList: List<Int>
    private var isPaused = false
    var nowPlaying: String = ""


    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer()
        mediaPlayer.setOnPreparedListener(this)
        trackList = listOf(R.raw.track1, R.raw.track2 ,R.raw.track3)
    }

    inner class LocalBinder: Binder() {
        fun getService():MusicPlayerService = this@MusicPlayerService
    }

    override fun onStartCommand(intent: Intent?, flags: Int,
                                startId: Int): Int {
        intent?.action?.let { action ->
            when (action){
                "ACTION_PLAY" -> playTrack(currentTrack)
                "ACTION_PAUSE" -> pauseTrack()
                "ACTION_SKIP" -> skipTrack()
                "ACTION_STOP" -> {
                    stopTrack()
                    stopSelf()
                }
            }
        }
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return LocalBinder()
    }

    override fun onPrepared(mp: MediaPlayer?) {
       mp?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }

    private fun playTrack(trackIndex:Int){
        val uri =
            Uri.parse("android.resource://$packageName/${trackList[trackIndex]}")
         nowPlaying = "Now Playing: Track: Track ${trackIndex + 1}"
        if (isPaused){
            mediaPlayer.start()
            isPaused = false
        }else{
            try {
                mediaPlayer.reset()
                mediaPlayer = MediaPlayer.create(this,uri)
                mediaPlayer.setOnPreparedListener(this)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun play(){
        playTrack(currentTrack)
    }

    fun pauseTrack(){
        mediaPlayer.pause()
        isPaused = true
    }

    fun skipTrack(){
        currentTrack = (currentTrack + 1) % trackList.size
        playTrack(currentTrack)
    }

    fun stopTrack() {
        mediaPlayer.stop()
        mediaPlayer.release()
        mediaPlayer = MediaPlayer()
    }
}