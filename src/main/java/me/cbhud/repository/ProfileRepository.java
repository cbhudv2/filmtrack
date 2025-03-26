package me.cbhud.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.cbhud.model.Profile;

@Dependent
public class ProfileRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Profile createProfile(Profile profile) {
        em.merge(profile);
        return profile;
    }

    @Transactional
    public Profile getProfileById(Integer id) {
        return em.find(Profile.class, id);
    }

    @Transactional
    public Profile updateProfile(Profile profile, String updateType) {
        Profile existingProfile = em.find(Profile.class, profile.getId());
        if (existingProfile == null) {
            throw new IllegalArgumentException("Profile not found");
        }

        switch (updateType) {
            case "email":
                existingProfile.setEmail(profile.getEmail());
                break;
            case "fullName":
                existingProfile.setFullName(profile.getFullName());
                break;
            case "username":
                existingProfile.setUsername(profile.getUsername());
                break;
            default:
                throw new IllegalArgumentException("Invalid update type");
        }

        em.merge(existingProfile);
        return existingProfile;
    }

    @Transactional
    public void deleteProfile(Profile p) {
        em.remove(p);
    }
}
