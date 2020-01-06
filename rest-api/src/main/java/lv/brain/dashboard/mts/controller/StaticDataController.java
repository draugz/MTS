package lv.brain.dashboard.mts.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lv.brain.dashboard.mts.model.Action;
import lv.brain.dashboard.mts.model.ConfigType;
import lv.brain.dashboard.mts.model.Environment;
import lv.brain.dashboard.mts.model.User;
import lv.brain.dashboard.mts.service.StaticDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
@RequiredArgsConstructor
public class StaticDataController {
    private final StaticDataService staticDataService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findUserAll() {
        return ResponseEntity.ok(staticDataService.findUserAll());
    }

    @GetMapping("/actions")
    public ResponseEntity<List<Action>> findActionAll() {
        return ResponseEntity.ok(staticDataService.findActionAll());
    }

    @GetMapping("/config-types")
    public ResponseEntity<List<ConfigType>> findConfigTypeAll() {
        return ResponseEntity.ok(staticDataService.findConfigTypeAll());
    }

    @GetMapping("/environments")
    public ResponseEntity<List<Environment>> findEnvironmentAll() {
        return ResponseEntity.ok(staticDataService.findEnvironmentAll());
    }
}
