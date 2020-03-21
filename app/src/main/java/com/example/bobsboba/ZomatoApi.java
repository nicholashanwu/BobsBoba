package com.example.bobsboba;

import android.content.Context;

import com.example.bobsboba.interfaces.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZomatoApi {

	private final Retrofit retrofit;

	private ZomatoApi(Retrofit retrofit) {
		this.retrofit = retrofit;
	}

	public static class Builder {
		com.example.bobsboba.SessionConfig session;

		Builder(com.example.bobsboba.SessionConfig session) {
			this.session = session;
		}


		public ZomatoApi build(Context context) {
			if (InterceptorHttpClientCreator.getOkHttpClient() == null) {
				return null;
			} else {
				Retrofit retrofit = new Retrofit.Builder()
						.addConverterFactory(GsonConverterFactory.create())
						.baseUrl("https://developers.zomato.com")
						.client(InterceptorHttpClientCreator.getOkHttpClient())
						.build();
				return new ZomatoApi(retrofit);
			}
		}

	}

	public static Builder with(com.example.bobsboba.SessionConfig session) {
		return new Builder(session);
	}

	public Service createService() {
		return retrofit.create(Service.class);
	}


}
