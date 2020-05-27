package com.example.kotlinunittestfootballmatchschedule.helper

class StringHelper {

    companion object{
        fun splitString(value:String,split:String):String{
            val stringBuilder = StringBuilder()
            val resultSplits:List<String> = value.split(split)

            for (split in resultSplits){
                stringBuilder.append(split+"\n")
            }

            return stringBuilder.toString()
        }
    }

}