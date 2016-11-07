package cn.coselding.flowerms.web;

import cn.coselding.flowerms.model.User;
import cn.coselding.flowerms.model.Worker;
import cn.coselding.flowerms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
@Controller
@RequestMapping(value = "/worker")
public class WorkerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Worker> workers = userService.listWorkers();
        model.addAttribute("workers", workers);
        return "worker_list";
    }

    @RequestMapping(value = "/query")
    public String query(@RequestParam(value = "workerID", required = false) Integer workerID,
                        @RequestParam(value = "workername", required = false) String workername,
                        Model model) {
        if (workerID == null) workerID = -1;
        if (workername == null) workername = "";
        List<Worker> workers = userService.queryWorkers(workerID, workername);
        model.addAttribute("workers", workers);
        return "worker_list";
    }

    @RequestMapping(value = "/{workerID}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("workerID") int workerID,
                         Model model) {
        int result = userService.deleteWorker(workerID);
        if (result <= 0) {
            model.addAttribute("message", "删除职工失败！！！");
            return "message";
        } else {
            model.addAttribute("message", "删除职工成功！！！");
            return "message";
        }
    }

    @RequestMapping(value = "/{workerID}/update", method = RequestMethod.GET)
    public String update(@PathVariable("workerID") int workerID,
                         HttpServletRequest request,
                         Model model) {
        Worker worker = userService.queryById(workerID);
        model.addAttribute("worker", worker);
        model.addAttribute("title", "修改职工");
        model.addAttribute("url", request.getContextPath() + "/worker/" + workerID + "/updateworker");
        return "worker_edit";
    }

    @RequestMapping(value = "/{workerID}/updateworker", method = RequestMethod.POST)
    public String updateworker(@PathVariable("workerID") int workerID,
                               @RequestParam("workername") String workername,
                               @RequestParam("status") short status,
                               Model model) {
        Worker worker = new Worker();
        worker.setStatus(status);
        worker.setWorkername(workername);
        worker.setWorkerID(workerID);
        int result = userService.updateWorker(worker);
        if (result >= 1) {
            model.addAttribute("message", "职工修改成功！！！");
        } else {
            model.addAttribute("message", "职工修改失败！！！");
        }
        return "message";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(HttpServletRequest request, Model model) {
        model.addAttribute("title", "添加职工");
        model.addAttribute("url", request.getContextPath() + "/worker/addworker");
        return "worker_edit";
    }

    @RequestMapping(value = "/addworker", method = RequestMethod.POST)
    public String addworker(@RequestParam("workername") String workername,
                            @RequestParam("status") short status,
                            Model model) {
        Worker worker = new Worker();
        worker.setStatus(status);
        worker.setWorkername(workername);
        int result = userService.addWorker(worker);
        if (result >= 1) {
            model.addAttribute("message", "职工添加成功！！！");
        } else {
            model.addAttribute("message", "职工添加失败！！！");
        }
        return "message";
    }
}
