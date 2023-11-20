package com.trading.TradingUpFundationBackend.commons.domains.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exercise_solution_trading")
public class ExerciseSolutionTradingEntity {
    @Id
    @Column(name = "solution_exercise_id")
    private Integer id;

    @Column(name = "solution_exercise_comment")
    private String comment;

    @Column(name = "solution_exercise_date")
    private LocalDate date;

    @Column(name = "solution_exercise_user_name")
    private String userName;

    @Column(name = "solution_exercise_user_id")
    private Integer userId;

    @Column(name = "solution_exercise_exercise_id")
    private Integer idExercise;

    @Column(name = "solution_exercise_file_path")
    private String file;
}
