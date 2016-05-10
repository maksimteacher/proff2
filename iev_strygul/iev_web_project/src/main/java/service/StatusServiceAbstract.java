package service;

import domain.Status;

public class StatusServiceAbstract extends ServiceAbstract {

    public StatusServiceAbstract(Class type) {
        super(type);
    }
    public Status findStatus (String statusValue) {
        return (Status) dao.findByRestrictionEq("status", statusValue);
    }
}
