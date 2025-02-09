package com.adambahri.mypmtool.domain;

import jakarta.persistence.*;
import java.util.Date;

    @Entity
    @Table(name = "projects")
    public class Project {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String team;

        @Column(nullable = false)
        private String channelName;

        @Column(unique = true, nullable = false)
        private String channelId;

        @Column(nullable = false)
        private String owner;

        @Temporal(TemporalType.TIMESTAMP)
        private Date created;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public String getChannelName() {
            return channelName;
        }

        public void setChannelName(String channelName) {
            this.channelName = channelName;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public Date getCreated() {
            return created;
        }

        public void setCreated(Date created) {
            this.created = created;
        }
    }

