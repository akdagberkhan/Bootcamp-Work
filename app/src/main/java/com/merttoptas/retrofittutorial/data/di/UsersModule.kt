package com.merttoptas.retrofittutorial.data.di

import com.merttoptas.retrofittutorial.data.remote.api.UsersService
import com.merttoptas.retrofittutorial.data.repository.UsersRepository
import com.merttoptas.retrofittutorial.data.repository.UsersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class UsersModule {

    @Provides
    fun provideUsersService(retrofit: Retrofit) : UsersService {
        return retrofit.create(UsersService::class.java)
    }

    @Provides
    fun provideUsersRepository(usersService: UsersService) : UsersRepository {
        return UsersRepositoryImpl(usersService)
    }

}