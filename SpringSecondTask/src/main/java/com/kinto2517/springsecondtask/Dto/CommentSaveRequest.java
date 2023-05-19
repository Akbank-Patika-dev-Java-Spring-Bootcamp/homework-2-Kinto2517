package com.kinto2517.springsecondtask.Dto;

public record CommentSaveRequest(String comment, Long personId, Long productId) {
}
