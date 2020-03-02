package com.example.letsgetcheckedassignment

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class apiTest {

    //check api response

    @Test
    fun `can get country data`() {
        // call the api
        val response = ApiClient.getClient.getData().execute()
        // verify the response is OK
        response.body()?.get(0)?.name
        assertThat(response.code(), `is`(equalTo(200)))
        assertThat(response.body()?.get(0)?.name, `is`(equalTo("Afghanistan")))

    }



}