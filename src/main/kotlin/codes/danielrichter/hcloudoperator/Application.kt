package codes.danielrichter.hcloudoperator

import io.javaoperatorsdk.operator.Operator
import io.javaoperatorsdk.operator.api.reconciler.Reconciler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import java.util.function.Consumer

@SpringBootApplication
class Application{
    @Bean
    fun customServiceController(): VolumeReconciler {
        return VolumeReconciler()
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun operator(controllers: List<Reconciler<*>?>): Operator {
        val operator = Operator()
        controllers.forEach(Consumer { reconciler -> operator.register(reconciler) })
        return operator
    }
}

