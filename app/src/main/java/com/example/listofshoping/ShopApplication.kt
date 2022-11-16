package com.example.listofshoping

import android.app.Application
import com.example.listofshoping.data.db.ShopDatabase
import com.example.listofshoping.data.repositories.ShopRepository
import com.example.listofshoping.ui.shoplist.ShopViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShopApplication: Application(), KodeinAware {
    override val kodein: Kodein =  Kodein.lazy {
        import(androidXModule(this@ShopApplication))
        bind() from singleton { ShopDatabase(instance()) }
        bind() from singleton { ShopRepository(instance()) }
        bind() from provider { ShopViewModelFactory(instance()) }
    }
}