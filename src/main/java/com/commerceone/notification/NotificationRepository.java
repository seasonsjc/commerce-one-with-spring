package com.commerceone.notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commerceone.shared.repository.BaseRepository;

//@Repository
//public class NotificationRepository extends BaseRepository<MailBox, Long> {
public interface NotificationRepository extends JpaRepository<MailBox, Long> {
}
