package com.example.lesson


import com.example.core.http.EntityCallback

//import com.example.core.http.EntityCallback

import com.example.core.http.HttpClient

import com.example.lesson.entity.Lesson

import com.google.gson.reflect.TypeToken


import java.lang.reflect.Type

import java.util.ArrayList


import androidx.annotation.NonNull

import androidx.annotation.Nullable
import com.example.core.http.HttpClient.get
import com.example.core.utils.toast


//import com.example.core.http.EntityCallback
//import com.example.core.http.HttpClient.get
//import com.example.core.utils.toast
//import com.example.lesson.entity.Lesson
//import com.google.gson.reflect.TypeToken

class LessonPresenter {
    companion object{
        private const val LESSON_PATH = "lessons"
    }


    private var activity: LessonActivity? = null

    constructor(activity: LessonActivity?) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList<Lesson>()

    private val type = object : TypeToken<List<Lesson>>() {}.type


    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread { activity!!.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread { toast(message) }
            }
        })
    }

    fun showPlayback() {
        val playbackLessons: ArrayList<Lesson> = arrayListOf()
        for (lesson in lessons) {
            if (lesson?.state === Lesson.State.PLAYBACK) {
                playbackLessons.add(lesson)
            }
        }
        activity!!.showResult(playbackLessons)
    }


}