package com.jgeun.fastcampus.sns.hiltextension.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dagger.hilt.GeneratesRootInput;

/**
 *
 * @author JGeun
 * @created 2025/03/01
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@GeneratesRootInput
public @interface InstallBinding {

	Class<?> component();
}
