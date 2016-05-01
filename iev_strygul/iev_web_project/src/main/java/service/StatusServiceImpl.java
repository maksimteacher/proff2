package service;

import domain.Status;

public class StatusServiceImpl extends ServiceImpl {

    public StatusServiceImpl(Class type) {
        super(type);
    }
    public Status findStatus (String statusValue) {
        return (Status) dao.findByRestrictionEq("status", statusValue);
    }
}
