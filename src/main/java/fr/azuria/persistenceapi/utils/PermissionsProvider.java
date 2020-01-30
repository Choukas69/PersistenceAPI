package fr.azuria.persistenceapi.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class PermissionsProvider {

    public static ArrayList<String> getPermissions(Object o) {
        ArrayList<String> permissions = new ArrayList<>();

        for (Field field : o.getClass().getDeclaredFields()) {
            Permission permission = field.getAnnotation(Permission.class);

            if (permission != null) {
                // If field is annotated with @Permission
                field.setAccessible(true);

                try {
                    if ((Boolean) field.get(Boolean.class)) {
                        permissions.add(permission.value());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return permissions;
    }
}
