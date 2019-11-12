using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HappyCommunity.Types
{
	public class Post
	{
        public long Id { get; set; }
        public string Title { get; set; }
        public string Decription { get; set; }
        public int Reward { get; set; }
        public string Creator { get; set; }

	}
}
