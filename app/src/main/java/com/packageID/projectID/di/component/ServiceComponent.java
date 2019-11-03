/*
 * Created By Foujeu Pavel <foujeupavel@gmail.com> on 6/8/2019.
 * Copyright (c) Variance technologies. All rights reserved.
 * Last modified 8/5/19 9:45 AM
 *
 *
 * <Class description here>
 */

package com.packageID.projectID.di.component;

import com.packageID.projectID.di.PerService;
import com.packageID.projectID.di.module.ServiceModule;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

}
