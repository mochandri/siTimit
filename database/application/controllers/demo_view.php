<?php
class demo_view extends CI_Controller{
  public function index(){
    $this->load->view('headerview');
    $this->load->view('contentview');
    $this->load->view('footerview');
  }
}
 ?>
