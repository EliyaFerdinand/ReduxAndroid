package pl.k2net.ktalanda.maroubrascanner

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject
import pl.k2net.ktalanda.maroubrascanner.main.MainViewModel
import pl.k2net.ktalanda.maroubrascanner.utils.BarEntryFactory
import pl.k2net.ktalanda.redux.Store
import javax.inject.Singleton

@Module
class AppModule(val app: App) {
    @Provides @Singleton fun provideApp() = app

    @Provides @Singleton fun provideStore(): Store {
        return Store(
                MaroubraReducer,
                PublishSubject.create(),
                hashMapOf(MainViewModel::class.toString() to MainViewModel()))
    }

    @Provides fun provideDataSet(): BarDataSet {
        val dataSet = BarDataSet(listOf(), "")
        dataSet.color = app.resources.getColor(R.color.colorPrimary)
        return dataSet
    }

    @Provides fun provideData(): BarData {
        val data = BarData()
        data.barWidth = 10f
        return data
    }

    @Provides @Singleton fun provideEntryFactory(): BarEntryFactory {
        return BarEntryFactory
    }
}
