package com.example.initialarsetup.androiddevs.furnituretryout

import android.Manifest
import com.google.ar.sceneform.ux.ArFragment


class CustomArFragment : ArFragment(){

    override fun getAdditionalPermissions(): Array<String> {
        val additionalPermission = super.getAdditionalPermissions()
        val permissionLength = additionalPermission.size
        val permission = Array(permissionLength+1){ Manifest.permission.WRITE_EXTERNAL_STORAGE }
        if (permissionLength > 0){
            System.arraycopy(additionalPermission, 0, permission, 1,permissionLength)
        }
        return permission
    }
}