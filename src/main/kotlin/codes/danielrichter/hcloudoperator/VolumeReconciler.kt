package codes.danielrichter.hcloudoperator

import io.javaoperatorsdk.operator.api.reconciler.*
import me.tomsdevsn.hetznercloud.HetznerCloudAPI
import me.tomsdevsn.hetznercloud.objects.request.CreateVolumeRequest
import java.lang.Exception


@ControllerConfiguration
class VolumeReconciler : Reconciler<Volume>, Cleaner<Volume> {
        override fun reconcile(volume: Volume, context: Context<Volume>?): UpdateControl<Volume> {
//        volume?.status = VolumeStatus(Status.CREATED)

            try{
                val client = HetznerCloudAPI(TOKEN)
                val response = client.createVolume(CreateVolumeRequest(volume.spec.size, volume.metadata.name, volume.spec.location,true,"ext4",volume.spec.server,HashMap()))
                println(response)
            }catch (e: Exception){
//                volume.status = VolumeStatus(Status.FAILED)
            }
        return UpdateControl.noUpdate()
    }

    override fun cleanup(volume: Volume?, context: Context<Volume>?): DeleteControl {
        println("delete: $volume")
        return DeleteControl.defaultDelete()
    }
}