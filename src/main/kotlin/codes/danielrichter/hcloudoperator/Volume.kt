package codes.danielrichter.hcloudoperator;

import com.fasterxml.jackson.annotation.JsonProperty
import io.fabric8.kubernetes.api.model.Namespaced
import io.fabric8.kubernetes.client.CustomResource
import io.fabric8.kubernetes.model.annotation.Group
import io.fabric8.kubernetes.model.annotation.Version

@Group("codes.danielrichter.hcloudoperator")
@Version("v1")
class Volume: CustomResource<VolumeSpec, VolumeStatus>(), Namespaced

enum class Status {
    CREATED, FAILED
}

data class VolumeStatus(
    @JsonProperty("status") val status: Status
)

data class VolumeSpec(
    @JsonProperty("status") val server: Long,
    @JsonProperty("size") val size: Long,
    @JsonProperty("location") val location: String
)
