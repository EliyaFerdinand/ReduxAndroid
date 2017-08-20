package pl.k2net.ktalanda.maroubrascanner

import dagger.Component
import pl.k2net.ktalanda.maroubrascanner.main.MainActivity
import pl.k2net.ktalanda.maroubrascanner.main.chart.SurfChart
import pl.k2net.ktalanda.maroubrascanner.main.details.SurfDetailsView
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(app: App)

    fun inject(mainActivity: MainActivity)

    fun inject(surfChart: SurfChart)

    fun inject(surfDetailsView: SurfDetailsView)
}
