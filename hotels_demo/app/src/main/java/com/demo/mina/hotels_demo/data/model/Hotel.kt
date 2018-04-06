package com.demo.mina.hotels_demo.data.model

/**
 * Created by Mina Alfy on 4/6/2018.
 */
/**
 * Class which provides a model for post
 * @constructor Sets all properties of the post
 * @property userId the unique identifier of the author of the post
 * @property id the unique identifier of the post
 * @property title the title of the post
 * @property body the content of the post
 */
data class Hotel(val userId: Int, val id: Int, val title: String, val body: String)