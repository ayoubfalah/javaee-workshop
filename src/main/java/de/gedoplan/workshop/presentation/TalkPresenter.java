package de.gedoplan.workshop.presentation;

import de.gedoplan.workshop.domain.Talk;
import de.gedoplan.workshop.persistence.TalkRepository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@Model
public class TalkPresenter
{
  @Inject
  TalkRepository talkRepository;

  List<Talk>     talks;

  @PostConstruct
  void postConstruct()
  {
    this.talks = this.talkRepository.findAll();
    // this.talks = this.talkRepository.findTalksWithSpeakers();
  }

  public List<Talk> getTalks()
  {
    return this.talks;
  }

  private Talk currentTalk;

  public String createTalk()
  {
    this.currentTalk = new Talk(null, null, null, null);
    return "editTalk";
  }

  public String editTalk(Talk talk)
  {
    this.currentTalk = talk;
    return "editTalk";
  }

  @Produces
  @Current
  public Talk getCurrentTalk()
  {
    return this.currentTalk;
  }

}
